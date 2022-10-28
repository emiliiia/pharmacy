package com.emilia.pharmacy.form.sqlForms;

/*
  @author emilia
  @project pharmacy_2
  @className SQLRoleForm
  @version 1.0.0
  @since 18.08.2022
*/
public class SQLRoleForm {
    private int id;
    private String rolename;

    public SQLRoleForm() {
    }

    public SQLRoleForm(int id, String rolename) {
        this.id = id;
        this.rolename = rolename;
    }

    public SQLRoleForm(String rolename) {
        this.rolename = rolename;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    @Override
    public String toString() {
        return "SQLRoleForm{" +
                "id=" + id +
                ", rolename='" + rolename + '\'' +
                '}';
    }
}
