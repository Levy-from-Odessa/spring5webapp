package guru.springframework.spring5webapp.web.model;

import java.util.List;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public class BeerPagesList extends PageImpl<BeerDto> {

  public BeerPagesList(List<BeerDto> content) {
    super(content);
    //TODO Auto-generated constructor stub
  }
  public BeerPagesList(List<BeerDto> content, Pageable pageable, long total) {
    super(content, pageable, total);
    //TODO Auto-generated constructor stub
  }
  
}
