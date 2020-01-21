@extends('layouts.master')

@section('content')

<div class="row">

    <div class="col-sm-4">

        {{-- TODO: Imagen de la película --}}
        <img src="{{$pelicula['poster']}}" class="float-right" />
    </div>
    <div class="col-sm-8">

        {{-- TODO: Datos de la película --}}
        <h2>{{$pelicula['title']}}</h2>
        <p><b>Año: </b>{{$pelicula['year']}}<br>
            <b>Director: </b>{{$pelicula['director']}}<br>
            <b>Sinopsis: </b>{{$pelicula['synopsis']}}<br>

            @if($pelicula['rented'])
            <b>Estado: </b>Película actualmente alquilada
            @else
            <b>Estado: </b>Película disponible para alquilar
            @endif
        </p>
        <p>
            @if($pelicula['rented'])
            <button type="button" class="btn btn-danger">Devolver película</button>
            @else
            <button type="button" class="btn btn-primary">Alquilar película</button>
            @endif
            <a href="{{action('CatalogController@getEdit', [1])}}" class="btn btn-warning"><i class="fas fa-pen"></i> Editar película</a>
            <a href="{{ action('CatalogController@getIndex') }}" class="btn btn-light"><i class="fas fa-chevron-left"></i> Volver al listado</a>
        </p>

    </div>
</div>

@endsection