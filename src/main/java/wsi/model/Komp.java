package wsi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("Komp")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Komp {
    String id;
    String cpu;

}
