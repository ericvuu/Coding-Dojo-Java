public class Project{
  private String name;
  private String description;

  // overload constructor methods
  public Project(){
  }

  public Project(String name){
    this.name = name;
  }

  public Project(String name, String description){
    this.name = name;
    this.description = description;
  }

  // instance method to return project name and description
  public String elevatorPitch(){
    return "Name: " + name + " " + "Description: " + description;
  }

  // Getter and Setters
  public String getName(){
    return name;
  }

  public void setName(String name){
    this.name = name;
  }

  public String getDescription(){
    return description;
  }

  public void setDescription(String description){
    this.description = description;
  }
}
