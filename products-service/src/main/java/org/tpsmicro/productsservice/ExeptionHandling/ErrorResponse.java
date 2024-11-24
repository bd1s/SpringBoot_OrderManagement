package org.tpsmicro.productsservice.ExeptionHandling;

import lombok.*;

/**
 * @author lamaachi
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
@Builder
public class ErrorResponse{
    private String message;
    private int status;
    private long timestamp;

}
