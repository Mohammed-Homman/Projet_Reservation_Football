package com.reservation.projet.j2ee;

import com.reservation.projet.j2ee.entity.Utilisateur;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    private Long utilisateur;
    private ResponseEntity<?> responseEntity;
}
