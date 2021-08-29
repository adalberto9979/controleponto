package com.example.demo;

import com.example.demo.model.UsuarioModel;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
                
            try {
                String url = "http://localhost:8080/usuario/listar/1";
                HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept", "application/json");
                if (conn.getResponseCode() != 200) {
                    System.out.println("Erro " + conn.getResponseCode() + " ao obter dados da URL " + url);
                }
                BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
                String output = "";
                String line;
                while ((line = br.readLine()) != null) {
                    output += line;
                }
                conn.disconnect();
                
                System.out.println(output);

                Gson gson = new Gson();
                UsuarioModel usuario = gson.fromJson(new String(output.getBytes()), UsuarioModel.class);
                System.out.println("ID: " + usuario.getId());
                System.out.println("Nome: " + usuario.getNome());

            } catch (IOException ex) {
//            Logger.getLogger(APIRest.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

/*        
    @Bean
    CommandLineRunner init(UsuarioRepository repository) {
        return args -> {
            repository.deleteAll();
            LongStream.range(1, 11)
                    .mapToObj(i -> {
                        UsuarioModel usuario = new UsuarioModel();
                        usuario.setNome("Contact " + i);
                        usuario.setSenha("contact" + i + "@email.com");
                        return usuario;
                    })
                    .map(v -> repository.save(v))
                    .forEach(System.out::println);
        };
    }        
*/

	@GetMapping("/teste")
	public String testes() {
		return "Pagina de teste Spring Boot!";
	}
        
        @Bean   //@RequestMapping("/login")
        public ModelAndView index(){
            return new ModelAndView("index");
        }        
}