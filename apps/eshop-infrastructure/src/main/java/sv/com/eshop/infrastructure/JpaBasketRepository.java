package sv.com.eshop.infrastructure;

import sv.com.eshop.core.entities.Basket;
import sv.com.eshop.core.entities.Basket.BasketIdentifier;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JpaBasketRepository extends JpaRepository<Basket, BasketIdentifier> {

    @Query("SELECT b FROM Basket b LEFT JOIN FETCH b.items WHERE b.buyerId = :buyerId")
    Optional<Basket> findByBuyerIdWithItems(@Param("buyerId") String buyerId);

}