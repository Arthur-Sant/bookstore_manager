package br.com.springboot.bookstoremanager.dtos;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MessageResponseDTO {

  private String message;
}