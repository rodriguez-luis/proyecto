package bo.ucb.edu.ingsoft.api;

import bo.ucb.edu.ingsoft.bl.BrandBl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/brand")
public class BrandApi {
    private BrandBl brandBl;



}
