```java
package com.arteco.iaautofixdemo.repository;

import com.arteco.iaautofixdemo.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
```