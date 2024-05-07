package ee.tlu.test0;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;

public interface SomeRepository extends JpaRepository<SomeEntity, Long> {
}
