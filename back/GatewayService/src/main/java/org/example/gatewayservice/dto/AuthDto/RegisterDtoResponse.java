package org.example.gatewayservice.dto.AuthDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDtoResponse {
    private long id;
    private String email;
    private String name;
    private int role;
}
