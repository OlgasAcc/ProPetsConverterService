package proPets.converter.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

public class PostResponseDto { //пост, который формируется (формат для будущего поиска с тэгами, локацией) и отправляется в Эластик для сохранения

	String id;

}
