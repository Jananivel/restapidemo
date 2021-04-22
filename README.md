# restapidemo
@SpringBootApplication
   -@EnableAutoConfiguration : It will configure all the required jar based on the jar added in the classpath
   -@Configuration :
   -@ComponentScan : will scan for all components, configuration in the base package
@Autowired :
@RestController : To indicate the class is a rest controller and should return a response
@RequestMapping("/proj") : all api url in the controller should start with /proj
@ApiOperation : Provides a detail of the api in a swagger
@GetMapping : Maps the http get request to a method
@PostMapping : Maps the http post request to a method
@PathVariable: Used to retrieve data from the URL
@RequestBody : the method parameter is bound with the web request


#Hibernate
@Entity - indicates class is a persistent java class
@Table - table that maps this entity
@Id : To indicate primary key in a table
@GeneratedValue : Generation strategy for the primary key (GenerationType.AUTO - Auto increment)
@Column : Column in database table 
   
   

Swagger URL: http://localhost:8080/swagger-ui.html#/
