    //pacotes


    //bibliotecas

    import io.github.bonigarcia.wdm.WebDriverManager;
    import org.junit.jupiter.api.*;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.chrome.ChromeDriver;
    import static org.hamcrest.CoreMatchersAssert.is;
    import static org.hamcrest.CoreMatcherAssert.assertThat;


    //classe
    public class cadastrotest {

    //atributos
    private static WebDriver driver;

    //funções, métodos

    //antes de tudo
    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    //antes do teste
    @BeforeEach
    public void testeCadastroSimples() {
        driver = new ChromeDriver();
        driver.get("https://front.serverest.dev/login");
        driver.manage().window().maximize();
    }

    //depois do teste
    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

    //teste
    @Test
    public void cadastroTeste() {
        assertThat(driver.findElement(By.linkText("Cadastre-se")).getText(), is("Cadastre-se"));
        driver.findElement(By.linkText("Cadastre-se")).click();
        driver.findElement(By.id("nome")).click();
        driver.findElement(By.id("nome")).sendKeys("testador");
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys("testador@teste.com.br");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("teste123");
        driver.findElement(By.id("administrador")).click();
        assertThat(driver.findElement(By.cssSelector(".btn-primary")).getText(), is("Cadastrar"));
        driver.findElement(By.cssSelector(".btn-primary")).click();
    }
}


