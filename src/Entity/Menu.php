<?php

namespace App\Entity;

use App\Repository\MenuRepository;
use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;

/**
 * @ORM\Entity(repositoryClass=MenuRepository::class)
 */
class Menu
{
    /**
     * @ORM\Id
     * @ORM\GeneratedValue
     * @ORM\Column(type="integer")
     */
    private $id;

    /**
     * @Assert\NotBlank(message="field can't be empty")
     * @Assert\Length(
     *      min = 5,
     *      minMessage="The minimum length is 5"
     *
     *     )
     * @ORM\Column(type="string", length=255)
     */
    private $name;

    /**
     *  @Assert\NotBlank(message="field can't be empty")
     *   @Assert\Range(
     *      min = 1,
     *      max = 500,
     *      minMessage = "Minimum Price Is 1",
     *      maxMessage = "Maximum Price is 500"
     * )
     * @ORM\Column(type="integer")
     */
    private $price;

    /**
     * @Assert\NotBlank(message="field can't be empty")
     * @Assert\Length(
     *      min = 5,
     *      minMessage="The minimum length is 5"
     *
     *     )
     * @ORM\Column(type="string", length=255)
     */
    private $category;

  /**
 * @Assert\NotBlank(message="field can't be empty")
 * @Assert\Length(
 *      min = 7,
 *      max = 100,
 *      minMessage = "The minimum length is 7 ",
 *      maxMessage = "The maximum length is 100" )
 * @ORM\Column(type="string", length=255)
 */
    private $description;

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getName(): ?string
    {
        return $this->name;
    }

    public function setName(string $name): self
    {
        $this->name = $name;

        return $this;
    }

    public function getPrice(): ?int
    {
        return $this->price;
    }

    public function setPrice(int $price): self
    {
        $this->price = $price;

        return $this;
    }

    public function getCategory(): ?string
    {
        return $this->category;
    }

    public function setCategory(string $category): self
    {
        $this->category = $category;

        return $this;
    }

    public function getDescription(): ?string
    {
        return $this->description;
    }

    public function setDescription(string $description): self
    {
        $this->description = $description;

        return $this;
    }
}
