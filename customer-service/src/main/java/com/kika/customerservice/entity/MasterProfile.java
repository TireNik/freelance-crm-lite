package com.kika.customerservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "master_profiles")
public class MasterProfile {
    @Id
    private Long userId;

    @Column(name="full_name", length = 100)
    private String fullName;

    @Column(name = "phone", length = 50)
    private String phone;

    @Column(name = "city", length = 50)
    private String city;

    @Column(name = "profession", length = 100)
    private String profession;

    @Column(name ="hourly_rate", length = 100)
    private String hourlyRate;

    @Column(name = "rating")
    private Double rating;

    @Column(name= "description", columnDefinition = "TEXT")
    private String description;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @MapsId
    private User user;
}
