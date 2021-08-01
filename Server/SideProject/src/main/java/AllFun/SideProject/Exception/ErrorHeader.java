package AllFun.SideProject.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import java.util.*;


@Data
@AllArgsConstructor
public class ErrorHeader {
    public static ResponseEntity<?> errorMessage(String s, HttpStatus status) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("message",s);

        return new ResponseEntity<>(httpHeaders, status);
    }

}
