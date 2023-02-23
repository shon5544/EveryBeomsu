package beomside.everybeomsu.dto.res.home;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class PostHomeResDto {
    private String title;
    private LocalDateTime posted_date;
    private String board_name;
}
