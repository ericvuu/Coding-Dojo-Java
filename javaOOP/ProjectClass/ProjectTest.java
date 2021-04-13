public class ProjectTest{
  public static void main(String[] args){
    Project project1 = new Project();
    Project project2 = new Project("Fiscal Budget");
    Project project3 = new Project("Capital Allocation", "The process of allocating financial resources to different areas of a business to increase efficiency and maximize profits");

    project1.setName("Research investment properties");
    project1.setDescription("Find a commercial lot for building");
    project2.setDescription("Generate budget proposal");

    System.out.println(project1.elevatorPitch());
    System.out.println(project2.elevatorPitch());
    System.out.println(project3.elevatorPitch());

    System.out.println("Project 1's name is : " + project1.getName());
    System.out.println("Project 1's description is : " + project1.getDescription());
  }
}
