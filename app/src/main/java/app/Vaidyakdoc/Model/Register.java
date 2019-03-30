package app.Vaidyakdoc.Model;

public class Register {

    String name;
    String phoneno;
    String docname;
    String docphone;
    String editvalue;
    String email;
    String age;

    public Register(String name, String phoneno, String docname, String docphone, String editvalue, String email, String age) {
        this.name = name;
        this.phoneno = phoneno;
        this.docname = docname;
        this.docphone = docphone;
        this.editvalue = editvalue;
        this.email = email;
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Register() {
    }


    public String getEditvalue() {
        return editvalue;
    }

    public void setEditvalue(String editvalue) {
        this.editvalue = editvalue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getDocname() {
        return docname;
    }

    public void setDocname(String docname) {
        this.docname = docname;
    }

    public String getDocphone() {
        return docphone;
    }

    public void setDocphone(String docphone) {
        this.docphone = docphone;
    }
}
