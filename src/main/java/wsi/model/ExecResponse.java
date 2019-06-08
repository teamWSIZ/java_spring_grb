package wsi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExecResponse {
    String command;
    String args;
    List<String> ouput;
    List<String> error;
}
