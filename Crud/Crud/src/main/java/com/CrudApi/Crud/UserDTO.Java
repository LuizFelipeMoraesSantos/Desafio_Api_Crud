package DTO;


import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
    public class UsuarioRequestDTO {
    private String nome;
    private String email;
    private String senha;
    private LocalDate dataNascimento;
    private String telefone;
    private String endereco;
    private String cidade;
    private String estado;
    private Boolean ativo;
}
