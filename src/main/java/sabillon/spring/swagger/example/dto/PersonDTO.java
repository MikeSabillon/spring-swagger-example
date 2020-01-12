package sabillon.spring.swagger.example.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import sabillon.spring.swagger.example.model.Person;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value = "Person")
public class PersonDTO {

    @ApiModelProperty(value = "Person Id", required = false, example = "1")
    private Long id;
    @ApiModelProperty(value = "Name of the person", required = true, example = "Miguel")
    @NotEmpty
    private String name;
    @ApiModelProperty(value = "Last name of the person", required = true, example = "Sabillon")
    @NotEmpty
    private String lastName;
    @ApiModelProperty(value = "Age of the person", required = true, example = "25")
    @Min(1)
    @NotNull
    private Integer age;

    public static PersonDTO entityToDto(Person person) {
        return PersonDTO.builder()
                .id(person.getId())
                .age(person.getAge())
                .lastName(person.getLastName())
                .name(person.getName())
                .build();
    }

    public static Person dtoToEntity(PersonDTO personDTO) {
        return Person.builder()
                .id(personDTO.getId())
                .age(personDTO.getAge())
                .lastName(personDTO.getLastName())
                .name(personDTO.getName())
                .build();
    }

    @Override
    public String toString() {
        return "Id: " + this.id + " | Name: " + this.name + " | LastName: " + this.lastName + " | age: " + this.age;
    }
}
