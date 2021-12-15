package com.project.model.storage;

import com.project.model.employee.Employee;
import com.project.model.product.ProductSupply;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Supply {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  private Storage storage;

  private LocalDate date;

  @OneToMany(mappedBy = "supply")
  @ToString.Exclude
  private List<ProductSupply> products;

  @ManyToMany
  @ToString.Exclude
  private List<Employee> employees;

  private void addProduct(ProductSupply productSupply){
    products.add(productSupply);
  }

  private void addAllProduct(Iterable<ProductSupply> productSupplies){
    productSupplies.forEach(products::add);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Supply supply = (Supply) o;
    return id != null && Objects.equals(id, supply.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}