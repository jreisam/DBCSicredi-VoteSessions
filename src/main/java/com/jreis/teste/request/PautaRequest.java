package com.jreis.teste.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel("Pauta request")
public class PautaRequest implements Serializable {

  private static final long serialVersionUID = -8458575684129896178L;

  @ApiModelProperty(value = "Nome da Pauta")
  @NotBlank(message = "campo não pode ser vazio")
  @JsonProperty("nome")
  private String nome;

}
