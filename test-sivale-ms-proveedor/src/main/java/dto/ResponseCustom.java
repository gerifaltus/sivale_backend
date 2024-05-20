package dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseCustom<T> {

	private Integer statusCode;
	private List<T> data;
	
}
