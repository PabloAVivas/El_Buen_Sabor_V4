package org.example.BuenSabor_V4.Entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Usuario extends Base{
    private String auth0Id;
    private String userName;

    @Override
    public String toString() {
        return "Usuario{" +
                "auth0Id='" + auth0Id + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
