## Budowanie dystrybucji aplikacj (frontend + backend)



1. Zbudować aplikację fronendową (folder `front`), 
    1. wykonać `ng build --prod`
    1. dystrybucja jest w folderze `/dist/nazwa_projektu`
    1. ten folder można albo zdeployować na webserwerze (apache/nginx/fenix),
       albo wykorzystać w aplikacji jak poniżej
1. Skopiować dystrybucję frontendową do folderu 
`/src/main/resources/static`
1. Zbudować całą aplikację (`maven->package`)
1. Zbudowana dystrybucja (tu: `/target/java_spring_grb_1.0.0-SNAPSHOT.jar`)
jest wykonywalna, można ją przenieść na dowolny PC i uruchomić przez
`java -jar java_spring_grb_1.0.0-SNAPSHOT.jar`
1.1 uwaga: jeśli budujemy z javą 11, to dobrze sprawdzić, 
czy uruchamiamy również z javaą 11 (lub 12, ...)
1.1 uruchomiona aplikacja zawiera i frontend i backend:
1.1.1 Całość jest dostępna na http://localhost:8086
1.1 możemy dostosować zachowanie aplikacji, przez
stworzenie pliku `application.properties`
w folderze w którym jest `.jar`, i np. umieszczenie
w nim linii `server.port=8080`  (powoduje, 
że aplikacja będzie dostępna na http://localhost:8080)