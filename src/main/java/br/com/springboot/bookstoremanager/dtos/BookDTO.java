package br.com.springboot.bookstoremanager.dtos;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
  
  private Long id;

  @NotBlank
  @Size(max = 200)
  private String name;

  @NotNull
  private Integer pages;

  @NotNull
  private Integer chapters;

  @NotBlank
  @Size(max = 100)
  @Pattern(regexp ="(?:ISBN(?:-10)?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$)[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$",
            message = "ISBN format must be a valid format")
  private String isbn;

  @NotBlank
  @Size(max = 200)
  private String publisherName;

  @NotNull
  // para validar as anotações para o author 
  @Valid
  private AuthorDTO author;

}
