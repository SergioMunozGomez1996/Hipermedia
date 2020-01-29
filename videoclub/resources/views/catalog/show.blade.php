@extends('layouts.master')

@section('content')

<div class="row">

    <div class="col-sm-4">

        {{-- TODO: Imagen de la película --}}
        <img src="{{$pelicula->poster}}" class="float-right" />
    </div>
    <div class="col-sm-8">

        {{-- TODO: Datos de la película --}}
        <h2>{{$pelicula->title}}</h2>
        <p><b>Año: </b>{{$pelicula->year}}<br>
            <b>Director: </b>{{$pelicula->director}}<br><br>
            <b>Sinopsis: </b>{{$pelicula->synopsis}}<br>
            <br>
            @if($pelicula->rented)
            <b>Estado: </b>Película actualmente alquilada
            @else
            <b>Estado: </b>Película disponible para alquilar
            @endif
        </p>
        <p>
            @if($pelicula->rented)
            <form action="{{action('CatalogController@putReturn', $pelicula->id)}}" method="POST" style="display:inline">
                @method('PUT')
                @csrf
                <button type="submit" class="btn btn-danger" style="display:inline">
                    Devolver película
                </button>
            </form>
            @else
            <form action="{{action('CatalogController@putRent', $pelicula->id)}}" method="POST" style="display:inline">
                @method('PUT')
                @csrf
                <button type="submit" class="btn btn-primary" style="display:inline">
                    Alquilar película
                </button>
            </form>
            @endif
            <a href="{{action('CatalogController@getEdit', $pelicula->id)}}" class="btn btn-warning"><i class="fas fa-pen"></i> Editar película</a>
            <form action="{{action('CatalogController@deleteMovie', $pelicula->id)}}" method="POST" style="display:inline">
                @method('DELETE')
                @csrf
                <button type="submit" class="btn btn-danger" style="display:inline">
                    <i class="far fa-trash-alt"></i>
                    Eliminar película
                </button>
            </form>
            <a href="{{ action('CatalogController@getIndex') }}" class="btn btn-light"><i class="fas fa-chevron-left"></i> Volver al listado</a>
        </p>

    </div>
</div>

@endsection