package guangyu.yang.edforumclone.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationEmail {
    private String title;
    private String receipient;
    private String body;
}
