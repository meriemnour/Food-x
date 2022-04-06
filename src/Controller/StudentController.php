<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class StudentController extends AbstractController
{
    /**
     * @Route("/frontend", name="frontend")
     */
    public function index(): Response
    {
        return $this->render('student/index.html.twig', [
            'controller_name' => 'StudentController',
        ]);
    }
    /**
     * @return Response
     * @Route("/Affiche", name="affiche")
     */
    public function Affiche(){
        return new Response("<h1>bonjour à tous</h1>");
    }

    /**
     * @param $name
     * @return Response
     * @Route("/AfficheName/{name}",name="AfficheName")
     */

    public function AfficheName($name){
        return $this->render('student/affiche.html.twig',
            ['n'=>$name]);
    }
}
