package guru.springframework.msscbeerservice.bootstrap;

import guru.springframework.msscbeerservice.domain.Beer;
import guru.springframework.msscbeerservice.repositories.BeerRepository;
import guru.springframework.msscbeerservice.web.model.BeerStyleEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Created by jt on 2019-05-17.
 */
@RequiredArgsConstructor
@Component
public class BeerLoader implements CommandLineRunner {

    public static final String BEER_1_UPC = "0631234200036";
    public static final String BEER_2_UPC = "0631234300019";
    public static final String BEER_3_UPC = "0083783375213";


    private final BeerRepository beerRepository;



    @Override
    public void run(String... args) throws Exception {
        //using data.sql file now
          loadBeerObjects();
    }
    private void loadBeerObjects() {
        Beer b1 = Beer.builder()
                               .beerName("Mango Bobs")
                               .beerStyle(BeerStyleEnum.IPA.name())
                               .minOnHand(12)
                               .quantityToBrew(200)
                               .price(new BigDecimal("12.95"))
                               .upc(BEER_1_UPC)
                               .build();

        Beer b2 = Beer.builder()
                               .beerName("Galaxy Cat")
                               .beerStyle(BeerStyleEnum.PALE_ALE.name())
                               .minOnHand(12)
                               .quantityToBrew(200)
                               .price(new BigDecimal("12.95"))
                               .upc(BEER_2_UPC)
                               .build();

        Beer b3 = Beer.builder()
                               .beerName("Pinball Porter")
                               .beerStyle(BeerStyleEnum.PALE_ALE.name())
                               .minOnHand(12)
                               .quantityToBrew(200)
                               .price(new BigDecimal("12.95"))
                               .upc(BEER_3_UPC)
                               .build();

        beerRepository.save(b1);
        beerRepository.save(b2);
        beerRepository.save(b3);
    }
}


/*
  //      System.out.println("Loaded Beers--------- :  " + beerRepository.count());

beerRepository.count()   <<-- as per documentation this .count() method return the number of
                        entities available, it means how many objects are created with this entity class
e.g
----   in our case if we have 12 record inserted for Beer Class  it means count() = 12


 */


