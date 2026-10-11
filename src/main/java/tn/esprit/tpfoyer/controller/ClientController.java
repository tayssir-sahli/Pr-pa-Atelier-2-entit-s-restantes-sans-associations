
package tn.esprit.tpfoyer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Client;
import tn.esprit.tpfoyer.service.IClientService;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final IClientService clientService;

    @PostMapping
    public Client create(@RequestBody Client client) {
        return clientService.create(client);
    }

    @GetMapping("/{id}")
    public Client findById(@PathVariable Long id) {
        return clientService.findById(id);
    }

    @GetMapping
    public List<Client> findAll() {
        return clientService.findAll();
    }

    @PutMapping("/{id}")
    public Client update(@PathVariable Long id,
                         @RequestBody Client client) {
        return clientService.update(id, client);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        clientService.deleteById(id);
    }
}
