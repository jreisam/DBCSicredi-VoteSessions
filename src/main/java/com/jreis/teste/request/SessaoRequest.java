package com.jreis.teste.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel("Sessão request")
public class SessaoRequest {

  @ApiModelProperty(value = "Duração (em minutos)", example = "1")
  @JsonProperty("duracao")
  @Min(value = 1, message = "O campo deve ser maior que 1")
  private Integer duracao = 1;

  @ApiModelProperty(value = "Id da Pauta", example = "1")
  @NotNull(message = "O campo não pode ser nulo")
  @JsonProperty("Pauta ID")
  private Long pautaId;


}
