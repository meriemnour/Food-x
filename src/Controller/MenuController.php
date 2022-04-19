<?php

namespace App\Controller;

use App\Entity\Menu;
use App\Form\MenuType;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class MenuController extends AbstractController
{
    /**
     * @Route("/menu", name="display_menu")
     */
    public function index(): Response
    {

        $menus = $this->getDoctrine()->getManager()->getRepository(Menu::class)->findAll();
        return $this->render('menu/index.html.twig', ['m' => $menus]


        );
    }

    /**
     * @Route("/AddMenu", name="Add_Menu")
     */
    public function AddMenu(Request $request): Response
    {
        $menu = new Menu();
        $form = $this->createForm(MenuType::class, $menu);
        $form->handleRequest($request);
        if ($form->isSubmitted() && $form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->persist($menu);
            $em->flush();
            $this->addFlash('info','added successfully!');
            return $this->redirectToRoute('display_menu');

        }
        return $this->render('menu/createmenu.html.twig', [
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/RemoveMenu/{id}", name="Remove_Menu")
     */
    public function RemoveMenu(Menu $menu): Response
    {
        {
            $em = $this->getDoctrine()->getManager();
            $em->remove($menu);
            $em->flush();
            $this->addFlash('info2','Menu Deleted!');

            return $this->redirectToRoute('display_menu');
        }
    }
    /**
     * @Route("/UpdateMenu/{id}", name="Update_Menu")
     */
    public function UpdateMenu(Request $request , $id): Response
    {$menu = $this->getDoctrine()->getManager()->getRepository(Menu::class)->find($id);
        $form = $this->createForm(MenuType::class, $menu);
        $form->handleRequest($request);
        if ($form->isSubmitted() && $form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->flush();
            $this->addFlash('info3','Menu Updated!');

            return $this->redirectToRoute('display_menu');

        }
        return $this->render('menu/updatemenu.html.twig', [
            'form' => $form->createView(),
        ]);
    }

}