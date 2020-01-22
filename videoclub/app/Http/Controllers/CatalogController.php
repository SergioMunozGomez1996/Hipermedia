<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Movie;

class CatalogController extends Controller
{
    public function getIndex(){
		$movies = Movie::all();
        return view('catalog.index', array('objetoPeliculas'=>$movies));
    }

    public function getShow($id){
		$movie = Movie::findOrFail($id);
        return view('catalog.show', array('pelicula'=>$movie));
    }

    public function getCreate(){
        return view('catalog.create');
    }
    public function getEdit($id){
		$movie = Movie::findOrFail($id);
        return view('catalog.edit', array('pelicula'=>$movie));
    }
}
