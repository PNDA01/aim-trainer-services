package aimtrainer.aimtrainerservices;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByAge(int age);

    List<User> findByPrenomAndAgeGreaterThanOrderByAgeDesc(String prenom, int age);

    @Query("select p from Personne p where p.prenom = :prenom or p.age = :age")
    List<User> trouverPersonneParAgeOuPrenom(@Param("prenom") String prenom, @Param("age") int age);
}
