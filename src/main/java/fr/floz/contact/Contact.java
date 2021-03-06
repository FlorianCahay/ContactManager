package fr.floz.contact;

import fr.floz.contact.properties.Birth;
import fr.floz.contact.properties.Email;
import fr.floz.contact.properties.Name;
import fr.floz.contact.properties.Phone;

import java.util.StringJoiner;

public class Contact {
    private Name name;
    private Phone phone;
    private Email email;
    private Birth birth;

    public Name getName() {
        return name;
    }

    public Phone getPhone() {
        return phone;
    }

    public Email getEmail() {
        return email;
    }

    public Birth getBirth() {
        return birth;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public void setBirth(Birth birth) {
        this.birth = birth;
    }

    public String toVCF() {
        var sb = new StringJoiner("\n");
        sb.add("BEGIN:VCARD");
        sb.add("VERSION:2.1");
        if (!name.isEmpty()) sb.add(name.toVCF());
        if (!phone.isEmpty()) sb.add(phone.toVCF());
        if (!email.isEmpty()) sb.add(email.toVCF());
        if (!birth.isEmpty()) sb.add(birth.toVCF());
        sb.add("END:VCARD");
        return sb.toString();
    }
}
