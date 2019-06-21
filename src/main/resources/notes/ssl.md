## Tworzenie serwisów https


#### keystore .p12
Główne zadanie polega na odpowiednim przygotowaniu
pliku `zzz.p12` zawierającego klucz prywatny (`zzz.key`) i certyfikat (`zzz.crt`) wraz
z pełnym łańcuchem zaufania (czyli certyfikatami ca-pośrednich aż do takich, którym ufają browsery).

Standardowo, klucz prywatny wygenerujemy sami przy tworzeniu zapytania o podpisanie certyfikatu (`.csr`).
Ma on postać:
```
-----BEGIN EC PRIVATE KEY-----
MIGkAgEBBDBFxKhrUz2cAk6dliUIFHEhm72Jci3UR+s5608iVL+UJcL5jduSXmCf
(...)
ar9S9MCaHxJgeP0gAVU1rBEdjIdMhZo=
-----END EC PRIVATE KEY-----
```
natomiast certyfikat dostarczany jest w postaci pliku certifikatu (`.crt`, albo `.pem`) i jednego lub 
większej liczby certyfikatów pośrednich (najlepiej w formacie jawnym, `.pem`). Do naszych celów
wszystkie te pliki sklejamy (tekstowo) do pliku `zzz.crt`; będzie on miał postać:
```
-----BEGIN CERTIFICATE-----
(...)
-----END CERTIFICATE-----

-----BEGIN CERTIFICATE-----
(...)
-----END CERTIFICATE-----

-----BEGIN CERTIFICATE-----
(...)
-----END CERTIFICATE-----

-----BEGIN CERTIFICATE-----
(...)
-----END CERTIFICATE-----

```

(gdzie dla konwencji dobrze, by najwyższy z certyfikatów był certyfikatem naszej domeny)

Keystore zawierający cały powyższy materiał tworzymy przez:
```
openssl pkcs12 -export -in zzz.crt -inkey zzz.key -out zzz.p12 -name somename
```
gdzie podczas operacji zostaniemy zapytani o hasło do tworzonego keystore'a. W stworzonym keystore, materiał
będzie dostępny pod aliasem `somename` (oczywiście nazwa dowolna).


#### Zabezpieczenie aplikacji spring-boot przy pomocy keystore'a
Załóżmy, że mamy zamiar naszą aplikację postawić na domenie `zzz.pl` (w tym celu, albo będzie ona musiała
być uruchomiona (przez `java -jar app.jar` na serwerze odpowiedzialnym za tą domenę, albo 
można aplikację uruchomić i testować lokalnie dodając `127.0.0.1 zzz.pl` do pliku `/etc/hosts` (linux/mac i
podobnie na win))).

W celu zmuszenia spring-boota do używania protokołu tls/ssl dodajemy do `application.properties` linie:
```
server.port=443
server.ssl.key-store=zzz.p12
server.ssl.key-store-password=verysecret
server.ssl.keyStoreType=PKCS12
server.ssl.keyAlias=somename
```
przy czym plik `zzz.p12` będzie musiał być dostępny w folderze, w którym uruchomimy aplikację. 

Serwis będzie dostępny pod https://zzz.pl:8443 (gdybyśmy użyli portu 443, to wystarczyłoby https://zzz.pl)

#### Troubleshooting
* Przy poprawnej konfiguracji aplikacja startuje bez błędu, i w logach widać linię:
```
2019-06-19 18:48:19.997  INFO 22782 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8443 (https) with context path ''
```

* W przypadku błędów zazwyczaj ostatnia linia stacktrace'a zawiera informację o typie błędu, np:

```
Caused by: java.io.FileNotFoundException: /home/pm/IdeaProjects/java_spring_grb/maix.p12 (No such file or directory)
```
 informuje nas o niedostępności file'a z keystorem. 

* W przypadku błędu:
```
Caused by: java.io.IOException: jsse.alias_no_key_entry
```
mamy do czynienia z brakiem klucza o wybranym alias-ie (`ssl.keyAlias`) w keystore-rze