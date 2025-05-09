package com.expertcode.exercicio3.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.expertcode.exercicio3.entidades.DTO.MarcaDTO;
import com.expertcode.exercicio3.utilitarios.ConversorDtoEntidade;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_marca")
public class Marca implements Serializable, ConversorDtoEntidade<MarcaDTO>{
	
	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	@JsonIgnore
	@OneToMany(mappedBy = "marca")
	private List<Veiculo> veiculos = new ArrayList<>();
	
	public Marca(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	@Override
	public MarcaDTO converter() {
		return new MarcaDTO(this);
	}	
}
