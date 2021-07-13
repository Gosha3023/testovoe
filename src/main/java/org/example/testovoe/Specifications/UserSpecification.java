package org.example.testovoe.Specifications;

import org.example.testovoe.models.UserModel;
import org.springframework.data.jpa.domain.Specification;

import java.sql.Timestamp;

public class UserSpecification {
    public static Specification<UserModel> equalStatus(Boolean status) {
        if (status == null)
            return null;
        return ((root, criteriaQuery, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("status"), status);
        });
    }

    public static Specification<UserModel> greaterThanTimestamp(Timestamp timestamp){
        if (timestamp == null)
            return null;
        return ((root, criteriaQuery, criteriaBuilder) -> {
            return criteriaBuilder.greaterThan(root.get("timestamp"), timestamp);
        });
    }
}
