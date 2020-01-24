<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Movie;

class CatalogController extends Controller
{
    public function getIndex()
    {
        $movies = Movie::all();
        return view('catalog.index', array('objetoPeliculas' => $movies));
    }

    public function getShow($id)
    {
        $movie = Movie::findOrFail($id);
        return view('catalog.show', array('pelicula' => $movie));
    }

    public function getCreate()
    {
        return view('catalog.create');
    }
    public function getEdit($id)
    {
        $movie = Movie::findOrFail($id);
        return view('catalog.edit', array('pelicula' => $movie));
    }

    public function postCreate(Request $request)
    {
        $p = new Movie;
        $p->title = $request->input('title');
        $p->year = $request->input('year');
        $p->director = $request->input('director');
        $p->poster = $request->input('poster');
        $p->rented = false;
        $p->synopsis = $request->input('synopsis');
        $p->save();

        return redirect()->action('CatalogController@getIndex');
    }

    public function putEdit(Request $request, $id)
    {
        $movie = Movie::findOrFail($id);
        $movie->title = $request->input('title');
        $movie->year = $request->input('year');
        $movie->director = $request->input('director');
        $movie->poster = $request->input('poster');
        $movie->synopsis = $request->input('synopsis');
        $movie->save();

        return redirect()->action('CatalogController@getShow', $id);
    }
}
