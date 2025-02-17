package az.developia.course.qrup28.dto.response.feign;

import lombok.Data;

@Data
public class OtherUser {
    public int id;
    public String name;
    public String username;
    public String email;
    public Address address;
    public String phone;
    public String website;
    public Company company;
}
