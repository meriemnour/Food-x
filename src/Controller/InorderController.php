<?php

namespace App\Controller;

use App\Entity\Inorder;
use App\Entity\Order;
use App\Repository\MenuRepository;
use App\Service\Cart\CartService;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class InorderController extends AbstractController
{
    /**
     * @Route("/Inorder", name="create_Inorderr")
     */
    public function createProduct( CartService $cartService, MenuRepository $menuRepository): Response
    {   $entityManager1 = $this->getDoctrine()->getManager();

        $order = new Order();
        $order->SetCustomerId(1);
        $order->setStatus("On Delevery");
        $date = new \DateTime('@'.strtotime('now'));
        $order->setTimeStamp( $date);
        $order->setTotal($cartService->getTotal());

        // tell Doctrine you want to (eventually) save the Product (no queries yet)
        $entityManager1->persist($order);

        // actually executes the queries (i.e. the INSERT query)
        $entityManager1->flush();
        // you can fetch the EntityManager via $this->getDoctrine()
        // or you can add an argument to the action: createProduct(EntityManagerInterface $entityManager)
        foreach ($cartService->getFullCart() as $item) {

            $entityManager = $this->getDoctrine()->getManager();

            $Inorder = new Inorder();
            $Inorder->setMenuId($item['menu']->getId());
            $Inorder->SetOrder($order);
            $Inorder->setQuantity($item['quantity']);

            // tell Doctrine you want to (eventually) save the Product (no queries yet)
            $entityManager->persist($Inorder);

            // actually executes the queries (i.e. the INSERT query)
            $entityManager->flush();
        }
        return $this->render('thanks/thanks.html.twig', []);
    }

}
