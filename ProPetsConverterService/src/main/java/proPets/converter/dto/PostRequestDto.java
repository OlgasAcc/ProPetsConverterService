package proPets.converter.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
public class PostRequestDto { //тот пост, что приходит из ЛФ для конвертации (пост из Монго)
	
	String id; //post id
	String flag;
	String type;
	String address;
	String distinctiveFeatures;
	String[] picturesURLs;
	@JsonFormat(pattern = "yyyy-MM-dd")
	LocalDateTime dateOfPublish;

}
