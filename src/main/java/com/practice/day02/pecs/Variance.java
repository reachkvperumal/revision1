package com.practice.day02.pecs;

import java.util.ArrayList;
import java.util.List;

public class Variance {

  //Consumer
  public void contraVariant(List<? extends BaseA> bList) {
    BaseA obj2 = bList.get(0);
    obj2.show();
  }

  //producer
  public List<? super BaseA> coVariant(BaseA baseA) {
    List<? super BaseA> result = new ArrayList<>();
    result.add(baseA);
    return result;
  }

  public static void main(String[] args) {
    Variance variance = new Variance();

    List<? super BaseA> objects = variance.coVariant(new BaseA());


  }

}
