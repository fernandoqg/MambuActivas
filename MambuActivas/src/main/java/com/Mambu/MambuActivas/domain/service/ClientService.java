package com.Mambu.MambuActivas.domain.service;

import com.Mambu.MambuActivas.domain.dto.ClientCreateResponseDTO;
import com.Mambu.MambuActivas.domain.model.Client;

public interface ClientService {

    ClientCreateResponseDTO createClient(Client client);
}
