import { TestBed } from '@angular/core/testing';

import { PeliculasAPIService } from './peliculas-api.service';

describe('PeliculasAPIService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PeliculasAPIService = TestBed.get(PeliculasAPIService);
    expect(service).toBeTruthy();
  });
});
