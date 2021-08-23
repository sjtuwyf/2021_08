package com.tanhua.dubbo.server.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Author ssqswyf
 * @Date 2021/8/20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "quanzi_time_line")
public class TimeLine implements java.io.Serializable {

    private static final long serialVersionUID = 9096178416317502524L;
    private ObjectId id;

    private Long userId; // 好友id
    private ObjectId publishId; //发布id

    private Long date; //发布的时间

}
