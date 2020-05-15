package com.jreis.teste.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel("Voto request")
public class VotoRequest implements Serializable {

  private static final long serialVersionUID = 4753561587146476862L;

  @ApiModelProperty(value = "Id da Pauta", example = "1")
  @NotNull(message = "O campo não poder ser nulo.")
  @JsonProperty("idPauta")
  private Long pautaId;

  @ApiModelProperty(value = "CPF do Associado", example = "79757812223")
  @NotBlank(message = "O campo não poder ser vazio.")
  @JsonProperty("cpf")
  @Size(min = 11, max = 11, message = "Necessário 11 dígitos para validar o cpf")
  private String associadoCPF;

  @ApiModelProperty(value = "Voto", example = "SIM")
  @NotBlank(message = "O campo não poder ser vazio.")
  @JsonProperty("voto")
  private String voto;


}
